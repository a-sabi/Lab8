public class Fraction {
    public int num;
    public int den;

    public Fraction(int num, int den) {
        try{
            if (den == 0){
                throw new Exception ("Invalid Input");
            }
            else {
                this.num = num;
                this.den = den;
            }
        }
        catch (Exception e){
            System.out.println("Invalid Input");
        }
    }

    public Fraction(){
        this.num = 1;
        this.den = 1;
    }

    public String toString(){
            return num + "/" + den;
    }

    public Fraction red(Fraction fract){
        int num = fract.num;
        int den = fract.den;
        int result = nod(num, den);
        num /= result;
        den /= result;
        return new Fraction(num, den);
    }

    private static int nod(int a, int b){
        if(b==0){
            return a;
        }
        return nod(b, a%b);
    }

    private static int nok(int a, int b){
        return (a * b)/nod(a, b);
    }

    public Fraction add(Fraction other){
        Fraction result = new Fraction();
        if(this.den == other.den){
            result.den = this.den;
            result.num = this.num + other.num;
        }
        else{
            int nok = nok(this.den, other.den);
            result.den = nok;
            result.num = this.num * (nok/this.den) + other.num * (nok/other.den);
        }
        result = red(result);
        return result;
    }

    public static Fraction add(Fraction fract1, Fraction fract2){
        Fraction result = new Fraction();
        if(fract1.den == fract2.den){
            result.den = fract1.den;
            result.num = fract1.num + fract2.num;
        }
        else{
            int nok = nok(fract1.den, fract2.den);
            result.den = nok;
            result.num = fract1.num * (nok/fract1.den) + fract2.num * (nok/fract2.den);
        }
        return result;
    }

    public Fraction sub(Fraction other){
        Fraction result = new Fraction();
        if(this.den == other.den){
            result.den = this.den;
            result.num = this.num - other.num;
        }
        else{
            int nok = nok(this.den, other.den);
            result.den = nok;
            result.num = this.num * (nok/this.den) - other.num * (nok/other.den);
        }
        result = red(result);
        return result;
    }

    public static Fraction sub(Fraction fract1, Fraction fract2){
        Fraction result = new Fraction();
        if(fract1.den == fract2.den){
            result.den = fract1.den;
            result.num = fract1.num - fract2.num;
        }
        else{
            int nok = nok(fract1.den, fract2.den);
            result.den = nok;
            result.num = fract1.num * (nok/fract1.den) - fract2.num * (nok/fract2.den);
        }
        return result;
    }


    public Fraction mul(Fraction other) {
        Fraction result = new Fraction();
        result.den = this.den * other.den;
        result.num = this.num * other.num;
        result = red(result);
        return result;
    }

    public static Fraction mul(Fraction fract1, Fraction fract2) {
        Fraction result = new Fraction();
        result.den = fract1.den * fract2.den;
        result.num = fract1.num * fract2.num;
        return result;
    }

    public Fraction div(Fraction other) {
        Fraction result = new Fraction();
        result.den = this.den * other.num;
        result.num = this.num * other.den;
        result = red(result);
        return result;
    }

    public static Fraction div(Fraction fract1, Fraction fract2) {
        Fraction result = new Fraction();
        result.den = fract1.den * fract2.num;
        result.num = fract1.num * fract2.den;
        return result;
    }
}