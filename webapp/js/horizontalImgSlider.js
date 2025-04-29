document.addEventListener('DOMContentLoaded', () => {
    const leftArrow = document.querySelector('.leftArrow');
    const rightArrow = document.querySelector('.rightArrow');
    const babysitters = document.querySelector('.babysitters');

    leftArrow.addEventListener('click', () => {
        babysitters.scrollBy({ left: -300, behavior: 'smooth' });
    });

    rightArrow.addEventListener('click', () => {
        babysitters.scrollBy({ left: 300, behavior: 'smooth' });
    });
});