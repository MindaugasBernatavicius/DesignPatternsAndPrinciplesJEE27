package cf.mindaugas._00_generalPrinciples;

public class _02_KISS {
    public static void main(String[] args) {
        // KISS - keep it simple stupid

        var day = getWeekDayComplex(5);
    }

    public static String getWeekDayComplex(int day) {
        if (day < 1 || day > 7)
            throw new IllegalStateException("day must be in range 1 to 7");
        String[] days = {
                "Monday", // 0
                "Tuesday", // 1
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday" // 6
        };
        return days[day - 1]; // 7
    }

    public static String getWeekDaySimple(int day) {
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                throw new IllegalStateException("day must be in range 1 to 7");
        }
    }

    // this will not work for java 8, 11 and so on (I think 17 is the lowest)
    public static String getWeekDaySimpleSwExpr(int day) {
        return switch(day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> throw new IllegalStateException(
                    "day must be in range 1 to 7"
            );
        };
    }
}
