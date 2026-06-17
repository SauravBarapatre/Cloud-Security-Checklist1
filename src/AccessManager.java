public class AccessManager {

    public static String getAccessLevel(String role) {

        if(role.equalsIgnoreCase("admin"))
            return "Full Access";

        if(role.equalsIgnoreCase("employee"))
            return "Limited Access";

        return "Access Denied";
    }
}
