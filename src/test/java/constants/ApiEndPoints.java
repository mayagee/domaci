package constants;

public class ApiEndPoints {

    //login
    public static final  String LOGIN = "auth/token/login/";

    //public
    public static  final String PUBLIC_CROCODILES = "public/crocodiles/";

    //private
    public static  final String MY_CROCODILES ="my/crocodiles/";
    public static  String SINGLE_CROCODILE (String crocodileId){return MY_CROCODILES + crocodileId;}




}
