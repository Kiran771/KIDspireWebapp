window.onload = function () {
  let slideIndex = 0;
  const slides = document.getElementsByClassName("imageslides");

  if (slides.length === 0) {
    console.error("No slides found with class 'imageslides'");
    return;
  }
  slides[0].classList.add("active");

  function showSlides() {
    for (let i = 0; i < slides.length; i++) {
      slides[i].classList.remove("active");
    }

    slideIndex++;
    if (slideIndex > slides.length) {
      slideIndex = 1;
    }

    slides[slideIndex - 1].classList.add("active");
    setTimeout(showSlides, 3000);
  }

  showSlides();
};
