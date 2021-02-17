

public class Polynomial {

    // Initiation of global arrays and variables for this class.
    private int exponent;
    private double[] base;

    /**Default constructor returns a  0 polynomial.
     * @return Polynomial
     * */ 
    public Polynomial() {
        this.base = new double[1];

        this.base[0] = 0;
        this.exponent = 0;
    }

    /** Constructor takes int d and double c as input.
     * @param double c
     * @param int d
     * @return Polynomial
     * */ 
    
    public Polynomial(double c, int d) {
        this.base = new double[d+1];

        this.base[d] = c;
        this.exponent = d;
    }

    /**Constructor takes array[] as input. 
     * @param double[] base
     * @return Polynomial
     * */ 
    public Polynomial(double[] base) {
        
        this.base = base;
        this.exponent = base.length-1;
    }

    public double getBase(int degree) {
        return this.base[degree];
    }

    /**method to get the degree 
     * @return int
     * */ 
    public int getDegree() {
        return exponent;
    }

     /** 
     * changes the polynomial type to string so that it can be printed to the console.
     * @return String
     */
    public String toString() {
        
        String polynumString= "";
        char operator;


        //for loop to loop through the array passed to polynomial(base[]).
        for ( int i = 0; i < base.length; i++) {

        //checks for multiple terms.    
        if ( base.length > 1 ) {                     

            //checks if number is positive.
            if (base[i] > 0 ) {                     

                operator = '+';
            }

            //checks if number is negative.
            else {
                operator = '-';
            }
            
            //checks if x^0 .
            if ( i == 0 ) {                           
                polynumString  = polynumString + base[i] ;
            }

            //checks if base is 1 or -1 to print x without 1 or -1 in front of it, cleaner looking output.
            else if (base[i] == 1 || base[i] == -1) {
                polynumString  = polynumString + " " + operator + " " + 'x' + '^' + i ;
            }

            //checks if base is 0 don't print the output.
            else if (base[i] == 0) {
                continue;
            }


            //printing all the terms that don't satisfy the above conditionals.
            else {
                polynumString  = polynumString + " " + operator + " " +  Math.abs(base[i])  + 'x' + '^' + i ;       
                }

            }

        //logic to print polynomial if array has only 1 variable in it.
        else {
            
            //if base is 0 output is 0
            if (base[i] == 0.0) {                    
                polynumString =  polynumString + 0;
            }

            //if base is not 0 print (base)x^exponent.
            else 
                 polynumString= polynumString  +  base[i] + 'x' + '^' + exponent;
        }

    }
        return polynumString;
        
    }

    /**evaluates the polynomial at x and returns the result. 
     * @param double x
     * @return double
     * */ 
    public double eval(double x) {

        double sum = 0;

        //loops through the bas[] array and evalutes value of polynomial at x using method 1.
        for (int y = 0; y < this.base.length; y++) {
            sum += this.base[y] * Math.pow(x, y);
        }

        return sum;
    }

    /** evaluates the polynomial at x and returns the result using Horner's method. 
     * @param double x
     * @return double
     * */ 
     
    public double eval2(double x) {

        double sum = 0;

        //loops through the bas[] array and evalutes value of polynomial at x using method 2.
        for (int y = this.base.length - 1; y >= 0; y--) {

            sum = (x * sum) + base[y];

        }
        return sum;
    }


    /** method to add the polynomials. 
     * @param Polynomial p2
     * @return Polynomial
     * */ 
    public Polynomial add(Polynomial p2)
    {
        //intialization
        Polynomial polyAdd;
        double[] polyAddArray;
        polyAddArray = new double[ (Math.max(p2.getDegree(), this.getDegree()))+1];

        //makes an array of original bases to be passed into the polynomial method.
        for(int i =0; i< base.length; i++){
            polyAddArray[i] += base[i];
        }

        //makes an array of new bases + original bases to be passed into the polynomial method.
        for(int i =0; i<= p2.getDegree();i++){
            polyAddArray[i] += p2.getBase(i);
        }

        polyAdd = new Polynomial(polyAddArray);

        return polyAdd;
    }


    /** method to subtract the polynomials. 
     * @param Polynomial p2
     * @return Polynomial
     * */ 
    public Polynomial sub(Polynomial p2)
    {
        //intialization
        Polynomial polySub;
        double[] polySubArray;
        polySubArray = new double[ (Math.max(p2.getDegree(), this.getDegree()))+1];

        //makes an array of original bases to be passed into the polynomial method.
        for(int i =0; i< base.length; i++){
            polySubArray[i] += base[i];
        }

        //makes an array of new bases - original bases to be passed into the polynomial method.
        for(int i =0; i<= p2.getDegree();i++){
            polySubArray[i] -= p2.getBase(i);
        }

        polySub = new Polynomial(polySubArray);

        return polySub;
    }

    /**  method to multiply the polynomials. 
     * @param Polynomial p2
     * @return Polynomial
     * */ 
    public Polynomial mul(Polynomial p2)
    {
        //intialization
        Polynomial polyMul;
        double[] polyMulArray;
        polyMulArray = new double[ ( p2.getDegree() + this.getDegree() ) +1 ];

        //makes an array of original bases to be passed into the polynomial method.
        for(int i =0; i< base.length; i++)
            {
                //makes an array of original bases*new bases to be passed into the polynomial method.
                for(int j =0; j <= p2.getDegree() ;j++)
                {
                    polyMulArray[i+j] += (base[i] * p2.getBase(j));
                }
            }

        polyMul = new Polynomial(polyMulArray);

        return polyMul;
    }


    /** method to compose the polynomials. 
     * @param Polynomial p2
     * @return Polynomial
     * */ 
    public Polynomial compose(Polynomial p2)
    {
        //intialization
        Polynomial polyCompose = new Polynomial();

        //creates polyBase array then with .add and .mul passes composes the polynomial.
        for (int i = this.getDegree(); i>=0; i--)
        {
            Polynomial polyBase = new Polynomial(base[i] , 0);
            polyCompose = polyBase.add(p2.mul(polyCompose));
        }

        return polyCompose;
    }

     /** 
     * method to divide the polynomials.
     * @param p2 
     * @return  Polynomial
     */
    public Polynomial div(Polynomial p2) {
        //intiates the polynomials polyDiv and polyQuotient
        Polynomial polyDiv = this;
        Polynomial polyQuotient = new Polynomial();
        
        //dividing smaller number by bigger number returns 0
        if ( p2.getDegree() > this.getDegree()) 
        {
            polyQuotient = new Polynomial();
            return polyQuotient;
        }

        for(int i =  ((polyDiv.getDegree()-p2.getDegree()) + 1 ) ; i > 0 ; i --) 
        {
            //creates polyLead as the lab02 document specifies.
            Polynomial polyLead = new Polynomial(( polyDiv.getBase(i) / p2.getBase(p2.getDegree() ) ), i - p2.getDegree());

            // Uuses the formula given in the lab02 document to find the polynomial.
            polyDiv = polyDiv.sub(polyLead.mul(p2));             
            polyQuotient = polyLead.add(polyQuotient);               
             
        }

        return polyQuotient;
    }
}
