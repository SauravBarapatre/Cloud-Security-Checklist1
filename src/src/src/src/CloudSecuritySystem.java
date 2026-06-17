import java.util.Scanner;

public class CloudSecuritySystem {

    static boolean validatePassword(String password) {

        return password.matches(
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$"
        );
    }

    public static void main(String[] args)
            throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if(!validatePassword(password)) {

            SecurityLogger.log(
                    "Weak password attempt by "
                            + username
            );

            System.out.println(
                    "Authentication Failed"
            );

            return;
        }

        System.out.print(
                "Role(admin/employee): "
        );

        String role = sc.nextLine();

        String access =
                AccessManager.getAccessLevel(role);

        System.out.println(
                "Access Level: "
                        + access
        );

        if(access.equals("Access Denied")) {

            SecurityLogger.log(
                    "Unauthorized Access"
            );

            return;
        }

        System.out.print(
                "Enter Sensitive Data: "
        );

        String data =
                sc.nextLine();

        String encrypted =
                EncryptionUtil.encrypt(data);

        System.out.println(
                "Encrypted Data: "
                        + encrypted
        );

        SecurityLogger.log(
                "Data Encrypted Successfully"
        );
    }
}
