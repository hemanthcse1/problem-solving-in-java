package examples.interviewquestions.strings.medium;

public class ValidateIPAddress {
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(queryIP);
        } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(queryIP);
        } else {
            return "Neither";
        }
    }

    private String validateIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) {
            return "Neither";
        }
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) {
                return "Neither";
            }
            if (part.charAt(0) == '0' && part.length() > 1) {
                return "Neither";
            }
            for (char ch : part.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }
    private String validateIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) {
            return "Neither";
        }
        String hexDigits = "0123456789abcdefABCDEF";
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) {
                return "Neither";
            }
            for (char ch : part.toCharArray()) {
                if (hexDigits.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        ValidateIPAddress validator = new ValidateIPAddress();
        System.out.println(validator.validIPAddress("172.16.254.1"));
        System.out.println(validator.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validator.validIPAddress("256.256.256.256"));
    }
}
