import spark.*;

public class Web {
  
  public Web() {
     Spark.get(new Route("/total") {
   public Object handle(Request request, Response response) {
     return "There are "+al.size()+ " shapes now.";
   }
  });
  
  Spark.get(new Route("/shapes/:num") {
   public Object handle(Request request, Response response) {
     synchronized(al) {
       for(int i = 0 ; i< Integer.parseInt(request.params(":num"));i++)
         al.add(new MyShape(random(400), random(400), 50, 50));  
     }
     return "added "+request.params(":num")+" shapes";
   }
  }); 
  
  Spark.get(new Route("/clean") {
   
    public Object handle(Request request, Response response) {
     synchronized(al) {
       al.clear();  
     }
     return "shapes cleared";
    }
    
  });
  
  }
}
