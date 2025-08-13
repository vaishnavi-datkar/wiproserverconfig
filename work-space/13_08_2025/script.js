const questions = [
    {
        question: "What is the capital of France?",
        options: ["Berlin", "Madrid", "Paris", "Rome"],
        correctAnswer: "Paris"
    },
    {
        question: "Which planet is known as the Red Planet?",
        options: ["Earth", "Mars", "Jupiter", "Venus"],
        correctAnswer: "Mars"
    },
    {
        question: "What is the largest ocean on Earth?",
        options: ["Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"],
        correctAnswer: "Pacific Ocean"
    },
    {
        question: "What is the square root of 64?",
        options: ["6", "7", "8", "9"],
        correctAnswer: "8"
    }
];

// --- 2. Get HTML Elements ---
// We find our HTML elements using their IDs so we can work with them.
const questionElement = document.getElementById('question');
const optionsForm = document.getElementById('options-form');
const nextButton = document.getElementById('next-btn');
const prevButton = document.getElementById('prev-btn');
const feedbackElement = document.getElementById('feedback');
const resultsContainer = document.getElementById('results');
const finalScoreElement = document.getElementById('final-score');
const restartButton = document.getElementById('restart-btn');
const quizContainer = document.getElementById('quiz');

// --- 3. Quiz State Variables ---
// These variables keep track of the current state of the quiz.
let currentQuestionIndex = 0;
let score = 0;
let answered = false; // A flag to check if the user has answered the current question.

// --- 4. Main Functions ---

// This function starts or resets the quiz.
function startQuiz() {
    currentQuestionIndex = 0;
    score = 0;
    answered = false;

    // Show the quiz and hide the results.
    quizContainer.classList.remove('hidden');
    resultsContainer.classList.add('hidden');
    
    // Show the first question.
    displayQuestion();
}

// This function displays the current question and its options.
function displayQuestion() {
    // Hide the feedback and "Next" button for a new question.
    feedbackElement.classList.add('hidden');
    nextButton.classList.add('hidden');
    answered = false;

    // Get the current question object.
    const currentQuestion = questions[currentQuestionIndex];
    
    // Update the question text.
    questionElement.textContent = currentQuestion.question;

    // Clear any old options.
    optionsForm.innerHTML = '';
    
    // Loop through each option and create a checkbox.
    currentQuestion.options.forEach((option, index) => {
        // Create a unique ID for each checkbox.
        const checkboxId = `option-${index}`;

        // Create the checkbox input element.
        const input = document.createElement('input');
        input.type = 'checkbox';
        input.id = checkboxId;
        input.name = 'quiz-option'; // All checkboxes should have the same name.
        input.value = option;
        
        // Create the label for the checkbox.
        const label = document.createElement('label');
        label.htmlFor = checkboxId;
        label.textContent = option;
        label.classList.add('option-label');
        
        // Add a click listener to the label. When clicked, it will check the answer.
        label.addEventListener('click', function(event) {
            // Prevent the label's default click action if a checkbox is already checked.
            if (answered) {
                event.preventDefault();
            }
        });
        
        // Add a change listener to the checkbox itself.
        input.addEventListener('change', function() {
            if (!answered) {
                checkAnswer(this.value);
            }
        });

        // Append the input and label to the form.
        optionsForm.appendChild(input);
        optionsForm.appendChild(label);
        optionsForm.appendChild(document.createElement('br')); // Add a line break for spacing.
    });

    // Show or hide the "Previous" button based on the current question.
    if (currentQuestionIndex > 0) {
        prevButton.classList.remove('hidden');
    } else {
        prevButton.classList.add('hidden');
    }
}

// This function checks if the selected answer is correct.
function checkAnswer(selectedOption) {
    if (answered) return; // Don't allow a second answer.
    answered = true;
    
    const currentQuestion = questions[currentQuestionIndex];
    
    // Get all the checkboxes on the page.
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
    checkboxes.forEach(checkbox => {
        checkbox.disabled = true; // Disable all checkboxes after an answer is given.
        
        // Check if this checkbox's value matches the correct answer.
        if (checkbox.value === currentQuestion.correctAnswer) {
            const label = document.querySelector(`label[for="${checkbox.id}"]`);
            if (label) {
                label.style.color = 'green'; // Change the text color of the correct answer.
            }
        }
    });

    // Now, check the specific selected option.
    if (selectedOption === currentQuestion.correctAnswer) {
        score++;
        feedbackElement.textContent = "Correct!";
        feedbackElement.classList.add('feedback-correct');
    } else {
        feedbackElement.textContent = "Wrong!";
        const selectedCheckbox = document.querySelector(`input[value="${selectedOption}"]`);
        const selectedLabel = document.querySelector(`label[for="${selectedCheckbox.id}"]`);
        if (selectedLabel) {
            selectedLabel.style.color = 'red'; // Change the text color of the wrong answer.
        }
        feedbackElement.classList.add('feedback-wrong');
    }
    
    // Show the feedback and the next button.
    feedbackElement.classList.remove('hidden');
    nextButton.classList.remove('hidden');
}

// This function moves to the next question.
function nextQuestion() {
    currentQuestionIndex++;
    if (currentQuestionIndex < questions.length) {
        displayQuestion();
    } else {
        showResults();
    }
}

// This function moves to the previous question.
function prevQuestion() {
    if (currentQuestionIndex > 0) {
        currentQuestionIndex--;
        displayQuestion();
    }
}

// This function shows the final score.
function showResults() {
    quizContainer.classList.add('hidden');
    resultsContainer.classList.remove('hidden');
    finalScoreElement.textContent = `You scored ${score} out of ${questions.length}!`;
}

// --- 5. Event Listeners ---
// We listen for clicks on our buttons and run the appropriate functions.
nextButton.addEventListener('click', nextQuestion);
prevButton.addEventListener('click', prevQuestion);
restartButton.addEventListener('click', startQuiz);

// --- 6. Start the quiz when the page loads.
startQuiz();