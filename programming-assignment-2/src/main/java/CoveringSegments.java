import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CoveringSegments {

    public static List<Integer> optimalPoints(List<Segment> segments) {
        Collections.sort(segments);
        int rightMostPoint = -1;
        List<Integer> points = new ArrayList<>();
        for (Segment segment : segments) {
            if (!segment.isInSegment(rightMostPoint)) {
                rightMostPoint = segment.end;
                points.add(rightMostPoint);
            }
        }
        return points;
    }

    public static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isInSegment(int point) {
            return point >= start && point <= end;
        }

        @Override
        public int compareTo(Segment s) {
            if (end > s.end) {
                return 1;
            } else if (end < s.end) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Segment> segments = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments.add(new Segment(start, end));
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
