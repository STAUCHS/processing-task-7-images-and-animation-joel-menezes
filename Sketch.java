import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  // Defines Images
  PImage imgCourt;
  PImage imgBasketball;

  // x and y coordinate for basketball
  float fltBasketBallX = 0;
  float fltBasketBallY = 0;
  float fltAngle = 0.05f;
  float fltShapeX = 80;
  float fltShapeY = 10;

  // basketball speed variables
  float fltXSpeed = 3;
  float fltYSpeed = 3;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    // Loads Images and Resizes
    imgCourt = loadImage("Court.png");
    imgBasketball = loadImage("Basketball.png");
    imgBasketball.resize(imgBasketball.width / 10, imgBasketball.height / 10);
  }

  public void draw() {
    // Chaging background
    background(imgCourt);

    // Shows Basketball, and Changes speed and makes a circle
    image(imgBasketball, fltBasketBallX, fltBasketBallY);
    fltBasketBallX = cos(fltAngle) * 50 + 189;
    fltBasketBallY = sin(fltAngle) * 50 + 111;
    fltAngle -= 0.05f;

    // Changes Speed for ellipse and displays
    fltShapeX += fltXSpeed;
    fltShapeY += fltYSpeed;
    ellipse(fltShapeX, fltShapeY, 30, 30);

    // Detects Collision for ball and deflects if hit
    if (fltShapeX > width - 15 || fltShapeX < 0) {
      fltXSpeed *= -1;
    }
    if (fltShapeY > height - 15 || fltShapeY < 0) {
      fltYSpeed *= -1;
    }
  }
}