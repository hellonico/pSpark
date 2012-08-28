class MyShape {
   float startX, startY;
   int sizeX, sizeY;
   int color1, color2, color3;
   
   public MyShape(float startX, float startY, int sizeX, int sizeY) {
     this.startX = startX;
     this.startY = startY;
     this.sizeX = sizeX;
     this.sizeY = sizeY;
     this.color1 = 128+int(random(127));
     this.color2 = 128+int(random(127));
     this.color3 = 128+int(random(127)); 
   }
   
   public void draw() {
     fill(color1, color2, color3);
     
     if(int(random(2))==0)
       startX += int(random(10));
     else
       startX -= int(random(10));
       
     if(int(random(2))==0)
       startY += int(random(10));
     else
       startY -= int(random(10));
     
     ellipse(startX, startY, sizeX,sizeY);  
   }  
}

