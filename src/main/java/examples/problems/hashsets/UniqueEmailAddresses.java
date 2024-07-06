package examples.problems.hashsets;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }

            local = local.replace(".", "");

            uniqueEmails.add(local + "@" + domain);
        }

        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddresses uea = new UniqueEmailAddresses();
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };

        System.out.println(uea.numUniqueEmails(emails));  // Output: 2
    }
}
