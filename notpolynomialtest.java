
public class PolynomialTester {
        public static void main(String[] args) {
                // Creating array to test
                double[] base1 = { 3,4,5,2};
                double[] base2 = {2,4,1};
                double[] base3 = {3,4,1};
                double[] base4 = {2,1};

                // Creating a test for the polynomial an array as input.
                Polynomial Poly1= new Polynomial(base1);
                Polynomial Poly2= new Polynomial(base2);
                Polynomial Poly3= new Polynomial(base3);
                Polynomial Poly4= new Polynomial(base4);

                //printing the results
                System.out.println("P(x) = "+Poly1.toString());
                System.out.println();
                System.out.println("Q(x) = "+Poly2.toString());
                System.out.println();
                System.out.println("P(x)+Q(x) = "+Poly1.add(Poly2).toString());
                System.out.println();
                System.out.println("P(x)-Q(x) = "+Poly1.sub(Poly2).toString());
                System.out.println();
                System.out.println("P(x)*Q(x) = "+Poly1.mul(Poly2).toString());
                System.out.println();
                System.out.println("R(x) = "+Poly3.toString());
                System.out.println();
                System.out.println("S(x) = "+Poly4.toString());
                System.out.println();
                System.out.println("R(S(x)) = "+Poly3.compose(Poly4).toString());
                System.out.println();
                System.out.println("R(x)/S(x) = "+Poly3.div(Poly4).toString());
        }
}
