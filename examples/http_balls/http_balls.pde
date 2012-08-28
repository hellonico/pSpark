import net.hellonico.spark.*;

ArrayList<MyShape> al = new ArrayList<MyShape>();

void setup() {
  size(600,600);
  noStroke();
  
  Web web = new Web();
  SparkLibrary lib = new SparkLibrary(this);
  
  println("Contact me at:"+lib.getPublicAddress());
}

void draw() {
  background(255);
  
  synchronized(al) {
    for(MyShape e : al) {
     e.draw(); 
    }  
  }
  
}

