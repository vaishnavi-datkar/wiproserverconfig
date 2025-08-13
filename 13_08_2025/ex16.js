let images = [
            "C:/Users/Vaishanvi Datkar/Downloads/15c224c52a789dd610e826eafbdda12d.jpg",
            "C:/Users/Vaishanvi Datkar/Downloads/6c2fb47f516fb6e1abc912278abe2601.jpg",
            "C:/Users/Vaishanvi Datkar/Downloads/3f7fb27842217d6f69abe5ab355e21e2.jpg",
            "C:/Users/Vaishanvi Datkar/Downloads/08faef509fe3b4eb451f47a5bf77737b.jpg",
            "C:/Users/Vaishanvi Datkar/Downloads/beautiful-modern-headphones-connected-player-listening-music-sound_124507-48995.jpg"
        ];
let currentIndex = 0;

        function showImage(index) {
            document.getElementById("galleryImage").src = images[index];
        }

        function nextImage() {
            currentIndex = (currentIndex + 1) % images.length;
            showImage(currentIndex);
        }

        function prevImage() {
            currentIndex = (currentIndex - 1 + images.length) % images.length;
            showImage(currentIndex);
        }

        // Show the first image on page load
        showImage(currentIndex);
    