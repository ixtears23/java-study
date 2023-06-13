package junseok.snr.study.java.api.switchs;

public class JavaSwitch {

    public String previousVersionSwitch(int i) {
        String dayOfWeek;
        switch (i) {
            case 1:
                dayOfWeek = "월";
                break;
            case 2:
                dayOfWeek = "화";
                break;
            case 3:
                dayOfWeek = "수";
                break;
            case 4:
                dayOfWeek = "목";
                break;
            case 5:
                dayOfWeek = "금";
                break;
            case 6:
                dayOfWeek = "토";
                break;
            case 7:
                dayOfWeek = "일";
                break;
            default:
                dayOfWeek = "X";
                break;
        }

        return dayOfWeek;
    }

    public String java14AfterVersionSwitch(int i) {
        return switch (i) {
            case 1 -> "월";
            case 2 -> "화";
            case 3 -> "수";
            case 4 -> "목";
            case 5 -> "금";
            case 6 -> "토";
            case 7 -> "일";
            default -> "X";
        };
    }
}
