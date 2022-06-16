package junseok.snr.study.pattern.design.structural.adapter;

public class Demo {
    public static void main(String[] args) {
        final RoundHole roundHole = new RoundHole(5);
        final RoundPeg roundPeg = new RoundPeg(5);
        if (roundHole.fits(roundPeg)) {
            System.out.println("둥근 못 r5는 둥근 구멍 r5에 맞습니다.");
        }

        final SquarePeg smallSquarePeg = new SquarePeg(2);
        final SquarePeg largeSquarePeg = new SquarePeg(20);

        final SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallSquarePeg);
        final SquarePegAdapter largeSquarePegAdapter = new SquarePegAdapter(largeSquarePeg);
        if (roundHole.fits(smallSquarePegAdapter)) {
            System.out.println("사각 못 w2는 둥근 구멍 r5에 맞습니다.");
        }
        if (!roundHole.fits(largeSquarePegAdapter)) {
            System.out.println("사각 못 w20은 둥근 구멍 r5에 맞지 않습니다.");
        }
    }
}
