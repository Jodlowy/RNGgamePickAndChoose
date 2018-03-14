package mathmodel;

public class GamePredictions {

    private double totOfBoxes = 12;
    private double pay = 8;
    private double life = 1;
    private double kill = 3;
    double avgp = (100 + 2 * 20 + 5 * 5) / pay;
    double add = (20 + 10 + 5) / 3;

    private double fact(double n) {
        return n == 1 || n == 0 ? 1 : n * fact(n - 1);
    }


    private double fun(double a, double x, double n) {
//        return a == 0 ? 0 :
        return (fact(pay - x) * fact(n - x - a))
                / ((fact(pay - x - a) * fact(n - x)));
    }

    public double scenaio1(int a) {
        return fun(a, 0, totOfBoxes) * kill / (totOfBoxes - a) * 3 / 4;
    }

    public double scenario2(int a, int b) {
        return fun(a, 0, totOfBoxes) * kill / (totOfBoxes - a) * 1 / 4 *
                fun(b, a, totOfBoxes - 1) * (kill - 1) / (totOfBoxes - 1 - a - b);
    }

    public double scenario3(int a, int b, int c) {
        return fun(a, 0, totOfBoxes) * life / (totOfBoxes - a) *
                fun(b, a, totOfBoxes - 1) * kill / (totOfBoxes - 1 - a - b) *
                fun(c, a + b, totOfBoxes - 2) * (kill - 1)
                / (totOfBoxes - 2 - a - b - c) * 3 / 4;
    }

    public double scenario4(int a, int b, int c, int d) {
        return fun(a, 0, totOfBoxes) * life / (totOfBoxes - a) *
                fun(b, a, totOfBoxes - 1) * kill / (totOfBoxes - 1 - a - b) *
                fun(c, a + b, totOfBoxes - 2) * (kill - 1)
                / (totOfBoxes - 2 - a - b - c) * 1 / 4 *
                fun(d, a + b + c, totOfBoxes - 3) * (kill - 2)
                / (totOfBoxes - 3 - a - b - c - d);
    }

    public double scenario5(int a, int b, int c, int d) {
        return fun(a, 0, totOfBoxes) * kill / (totOfBoxes - a) * 1 / 4 *
                fun(b, a, totOfBoxes - 1) * life / (totOfBoxes - 1 - a - b) *
                fun(c, a + b, totOfBoxes - 2) * (kill - 1) / (totOfBoxes - 2 - a - b - c) *
                fun(d, a + b + c, totOfBoxes - 3) * (kill - 2)
                / (totOfBoxes - 3 - a - b - c - d);
    }

    public double[] getAveragePrize() {

        double[] results = new double[2];

        double[] scenarios = new double[5];
        double payment = 0;
        double pcount = 0;

        // First Scenario
        for (int i = 0; i <= pay; i++) {
            double t = scenaio1(i);
            scenarios[0] += t;
            payment += t * (avgp * i + add);
            pcount += t * i;
        }

        //Second Scenario
        for (int i = 0; i <= pay; i++) {
            for (int j = 0; j <= pay - i; j++) {
                double t = scenario2(i, j);
                scenarios[1] += t;
                payment += t * (avgp * (i + j) + add);
                pcount += t * (i + j);
            }
        }

        //Third Scenario
        for (int i = 0; i <= pay; i++) {
            for (int j = 0; j <= pay - i; j++) {
                for (int k = 0; k <= pay - i - j; k++) {
                    double t = scenario3(i, j, k);
                    scenarios[2] += t;
                    payment += t * (avgp * (i + j + k) + add);
                    pcount += t * (i + j + k);
                }
            }
        }

        //Fourth Scenario
        for (int i = 0; i <= pay; i++) {
            for (int j = 0; j <= pay - i; j++) {
                for (int k = 0; k <= pay - i - j; k++) {
                    for (int l = 0; l <= pay - i - j - k; l++) {
                        double t = scenario4(i, j, k, l);
                        scenarios[3] += t;
                        payment += t * (avgp * (i + j + k + l) + add);
                        pcount += t * (i + k + l + l);
                    }
                }
            }
        }


        //Fifth Scenario
        for (int i = 0; i <= pay; i++) {
            for (int j = 0; j <= pay - i; j++) {
                for (int k = 0; k <= pay - i - j; k++) {
                    for (int l = 0; l <= pay - i - j - k; l++) {
                        double t = scenario5(i, j, k, l);
                        scenarios[4] += t;
                        payment += t * (avgp * (i + j + k + l) + add);
                        pcount += t * (i + j + k + l);
                    }
                }
            }
        }

        /**
         *  Below code shows sum of average as well as average for each possible scenario
         *
         *
         double sum = 0;
         for (double e : scenarios) {
         sum += e;
         }

         System.out.println(sum);
         for (double e : scenarios) {
         System.out.print(e + " | ");
         }
         *
         *
         *
         **/
        results[0] = payment;
        results[1] = pcount;

        return results;
    }
}
