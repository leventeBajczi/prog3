package labdrei;

public class NotEnoughParamsException extends Exception {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("Not enough parameters.");
    }
}
