package hundreadtwintyonetothirty;

public class PritNumberUsingThreads {
	final static int MAX_NUMBERS = 10;

	public static void main(String[] args) {
		 // shared object
		PritNumberUsingThreads obj = new PritNumberUsingThreads();
	    // Creating 3 threads
	    Thread t1 = new Thread(new NumberRunnable(obj, 0), "T1");
	    Thread t2 = new Thread(new NumberRunnable(obj, 1), "T2");
	   // Thread t3 = new Thread(new NumberRunnable(obj, 2), "T3");
	    t1.start();
	    t2.start();
	    //t3.start();

	}
	static class  NumberRunnable implements Runnable{
		PritNumberUsingThreads obj;
		  int threadNumber;
			static volatile int number = 0;
		  NumberRunnable(PritNumberUsingThreads obj, int result){
		    this.obj = obj;
		    this.threadNumber = result;
		  }
		  @Override
		  public void run() {   
		    synchronized(obj) {	
		      while (number < PritNumberUsingThreads.MAX_NUMBERS - 1) {
		        while(number % 2 != threadNumber){
		          try {
		            obj.wait();
		          } catch (InterruptedException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		          }
		        }
		        System.out.println(Thread.currentThread().getName() + " - " + ++number);
		        obj.notifyAll();
		      }
		    }                            
		  }
		}
}

