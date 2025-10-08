package db;

public class GenerateId {
    public static Long phoneId = 0L;
    public static Long genPhoneId () {
        return ++phoneId;
    }
}
