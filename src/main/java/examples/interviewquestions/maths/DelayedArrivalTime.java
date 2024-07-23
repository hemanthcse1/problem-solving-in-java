package examples.interviewquestions.maths;

public class DelayedArrivalTime {
    public static int findDelayedArrivalTime(int arrivalTime,
                                             int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    public static void main(String[] args) {
        System.out.println(findDelayedArrivalTime(22, 3));
        System.out.println(findDelayedArrivalTime(10, 5));
        System.out.println(findDelayedArrivalTime(23, 2));
        System.out.println(findDelayedArrivalTime(0, 24));
    }
}
