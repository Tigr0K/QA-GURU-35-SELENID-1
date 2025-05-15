package tests;

public class TestData {
    static TestVar testVar = new TestVar();
    public static String firstName = testVar.getFirstName();
    public static String lastName = testVar.getLastName();
    public static String email = testVar.getEmail();
    public static String gender = testVar.getGender();
    public static String subject = testVar.getSubject();
    public static String number = testVar.getNumber();
    public static String hobby = testVar.getHobby();
    public static String day = testVar.getDay();
    public static String month = testVar.getMonth();
    public static String year = testVar.getYear();
    public static String state = testVar.getState();
    public static String city = testVar.getCity(state);
    public static String address = testVar.getAddress();


    }
