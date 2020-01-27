abstract public class Employee {
// Protected Instance Variables:  
   protected String name;  
   protected double rate;  
   protected int hours;
   protected int id;
     
// Public Methods:  
   public Employee(){
      name = "";
      rate = 0;
      hours = 0;
      id = idCounter;
      idCounter++;
   }
  
   public boolean setName(String nm){
      if (nm.equals(""))
         return false;
      else{
         name = nm;
         return true;
      }
   }
        
   public boolean setRate(double rt){
      if (!(LOW_RATE <= rt && rt <= HIGH_RATE))
         return false;
      else{
         rate = rt;
         return true;
      }
   }
  
   public boolean setHours(int hrs){
      if (!(LOW_HOURS <= hrs && hrs <= HIGH_HOURS))
         return false;
      else{
         hours = hrs;
         return true;
      }
   }
  
   public String getName(){
      return name;
   }

    public int getID() {
        return id;
    }

   @Override
   public String toString() {
      return "(" + id + ")" + name + ". Hours: " + hours + ". Rate: " + rate + ". Pay: " + getPay();
   }

   abstract public double getPay();
   
   //---------------------------------------
   
   public static double LOW_RATE = 6.75;
   public static double HIGH_RATE = 30.50;
   public static double LOW_HOURS = 1;
   public static double HIGH_HOURS = 60;
   
   protected static double totalPay = 0;
   protected static int idCounter = 1000;
   
   public static String getNameRules() {
      return "nonblank";
   }
   
   public static String getTypeRules() {
      return "1 or 2";
   }
   
   public static String getRateRules() {
      return getRule (LOW_RATE, HIGH_RATE);
   }
   
   public static String getHoursRules() {
      return getRule (LOW_HOURS, HIGH_HOURS);
   }

   public static boolean typeOK (int type) {
      return type == 1 || type == 2;
   }
   
   public static double getTotalPay() {
      return totalPay;
   }
   
   private static String getRule (double low, double high) {
         return "between " + low + " and " + high + ", inclusive";
   }
}

