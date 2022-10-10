package environment;

import static environment.ConfigReader.getValue;

public class ConfigSetup {

    public static String getBaseUrl() { return getValue("BASE_URL"); }
    public static String getMainUser() { return getValue("MAIN_USER"); }
    public static String getDefaultPsw() {return getValue("DEFAULT_PSW");}
}
