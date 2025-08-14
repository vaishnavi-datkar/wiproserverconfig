function login() {
      const userId = document.getElementById("userId").value;
      const password = document.getElementById("password").value;

      if (userId && password) {
        // Store userId in localStorage
        localStorage.setItem("userId", userId);
        document.getElementById("status").textContent = " Logged in as " + userId;
      } else {
        document.getElementById("status").textContent = "! Please enter both User ID and Password.";
      }
    }

    function logout() {
      // Remove userId from localStorage
      localStorage.removeItem("userId");
      document.getElementById("status").textContent = " Logged out.";
    }

    // Check on page load if already logged in
    window.onload = function() {
      const savedUser = localStorage.getItem("userId");
      if (savedUser) {
        document.getElementById("status").textContent = " Logged in as " + savedUser;
      }
    }