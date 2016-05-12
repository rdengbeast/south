Paddle left, right;
Ball ball;
boolean upkey, downkey, wkey, skey, ckey; //, gamedone, somebodywon;
boolean gamedone = true;
boolean somebodywon = false;

void setup()
{
  upkey = false;
  downkey = false;
  wkey = false;
  skey = false;
  
  size(1200, 700);
  left = new Paddle(50);
  right = new Paddle(1150);
  ball = new Ball(600, 350, 5, 0);
}
void draw()
{
  if(ball.getXVelocity() < 0 )
    ball.setXVelocity(ball.getXVelocity() - 0.02);
  else
    ball.setXVelocity(ball.getXVelocity() + 0.02);

  clear();
  check();
  checkkeys();
  fill(200);
  ellipse((float)(ball.getX()), (float)(ball.getY()), 20.0, 20.0 );
   
  fill(0, 0, 255);

  quad((float)left.getX() - 10, (float)left.getY() - 50, (float)left.getX() + 10, (float)left.getY() - 50,
       (float)left.getX() + 10, (float)left.getY() + 50, (float)left.getX() - 10, (float)left.getY() + 50);

  fill(51, 102, 0);

  quad((float)right.getX() - 10, (float)right.getY() - 50, (float)right.getX() + 10, (float)right.getY() - 50,
       (float)right.getX() + 10, (float)right.getY() + 50, (float)right.getX() - 10, (float)right.getY() + 50);
    
  if(gamedone )
    gamedonegraphics();
}

void gamedonegraphics()
{
  clear();
  
  fill(255, 0, 127);
  if( somebodywon)
  {
    if(ball.getX() < 20)
      text("right won!", 300, 150 );
    else
      text("left won!", 300, 150 );
    text("press c to play again.", 400, 300);
  }
  else
    printcontrols();
}
void printcontrols()
{
  clear();
  background( 0 );
  textSize(55);
  
  fill(0, 0, 255);
  text("controls: ", 300, 100);
  text("adjust right: up/down arrows", 100, 300);
  text("press c to continue", 300, 600);
  
  fill(51, 102, 0);
  text("adjust left: w/s", 250, 350);
  text("fire: space", 250, 550);
  
}
void keyPressed()
{
  keywasPressed(true);
}
void keyReleased()
{
  keywasPressed(false);
}
void keywasPressed(boolean setto)
{
  if(key == CODED )
  {
    if(keyCode == UP)
      upkey = setto;
    if(keyCode == DOWN)
      downkey = setto;
  }
  if(key == 'w' )
    wkey =  setto;
  if(key == 's')
    skey = setto;
  if(key == 'c')
    ckey = setto;
}
void checkkeys()
{
  if(wkey)
    left.moveUp();
  else if(skey)
    left.moveDown();
  
  if(upkey)
    right.moveUp();
  else if(downkey)
    right.moveDown();
    
  if(ckey && gamedone)
  {
    somebodywon = false;
    gamedone = false;
    setup();
    
  }
}
void check()
{
  if (ball.getY() <= 20 )
    ball.setYVelocity(ball.getYVelocity() * (-1));
  else if (ball.getY() >= 680)
    ball.setYVelocity(ball.getYVelocity() * (-1));
  ball.setY(ball.getY() + ball.getYVelocity() );


  double leftyDist = left.getY() - ball.getY();
  double rightyDist = right.getY() - ball.getY();
  if (ball.getX() > 50 && ball.getX() - 50 <= 20 )
  {
    if(Math.abs(leftyDist) < 50 )
    {
      ball.setXVelocity( ball.getXVelocity() * (-1) );
      ball.setYVelocity( ball.getYVelocity() - leftyDist * 0.3);
    }
  } 
  else if (ball.getX() < 1150 && 1150 - ball.getX() <= 20 )
  {
    if( Math.abs(rightyDist) < 50 )
    {
      ball.setXVelocity( ball.getXVelocity() * (-1) );
      ball.setYVelocity( ball.getYVelocity() - rightyDist * 0.3);
    }
  }
  if(ball.getX() < 20 || ball.getX() > 1180)
  {
    gamedone = true;
    somebodywon = true;
  }
  ball.setX(ball.getX() + ball.getXVelocity() );
}
class Paddle
{
  double xpos, ypos, velocity;
  public Paddle(double x)
  {
    ypos = 350;
    xpos = x;
    velocity = 10;
  }
  public void moveUp()
  {
    if (ypos > 50 )
      ypos -= velocity;
  }
  public void moveDown()
  {
    if (ypos < 650)
      ypos += velocity;
  }
  public double getX()
  {
    return xpos;
  }
  public double getY()
  {
    return ypos;
  }
}
class Ball
{
  double xpos, ypos, xvelocity, yvelocity;
  public Ball(double x, double y, double xv, double yv)
  {
    xpos = x;
    ypos = y;
    xvelocity = xv;
    yvelocity = yv;
  }
  public void setX(double x)
  {
    xpos = x;
  }
  public void setY(double y)
  {
    ypos = y;
  }
  public void setXVelocity(double xv)
  {
    if(Math.abs(xv) < 20)
      xvelocity = xv;
  }
  public void setYVelocity(double yv)
  {
    if(Math.abs(yv) < 10)
      yvelocity = yv;
  }
  public double getX()
  {
    return xpos;
  }
  public double getY()
  {
    return ypos;
  }
  public double getXVelocity()
  {
    return xvelocity;
  }
  public double getYVelocity()
  {
    return yvelocity;
  }
}

