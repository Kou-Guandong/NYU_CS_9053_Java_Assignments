public class ComplexNumber extends Number implements Cloneable, Comparable<Number> {
        private double a;
        private double b;
        public long serialVersionUID = 1;

        public ComplexNumber() {

        }

        public ComplexNumber(double a) {
                this.a = a;
        }

        public ComplexNumber(double a, double b) {
                this.a = a;
                this.b = b;
        }

        public double getReal() {
                return this.a;
        }

        public double getImaginary() {
                return this.b;
        }

        public String add(ComplexNumber c2) {
                double real = this.getReal() + c2.getReal();
                double imaginary = this.getImaginary() + c2.getImaginary();
                return (new ComplexNumber(real, imaginary)).toString();
        }

        public String subtract(ComplexNumber c2) {
                double real = this.getReal() - c2.getReal();
                double imaginary = this.getImaginary() - c2.getImaginary();
                return (new ComplexNumber(real, imaginary)).toString();
        }

        public String multiply(ComplexNumber c2) {
                double c1Real = this.getReal();
                double c2Real = c2.getReal();
                double c1Ima = this.getImaginary();
                double c2Ima = c2.getImaginary();
                double real = c1Real * c2Real - c1Ima * c2Ima;
                double imaginary = c1Ima * c2Real + c1Real * c2Ima;
                return (new ComplexNumber(real, imaginary)).toString();
        }

        public String divide(ComplexNumber c2) {
                double c1Real = this.getReal();
                double c2Real = c2.getReal();
                double c1Ima = this.getImaginary();
                double c2Ima = c2.getImaginary();
                double real = (c1Real * c2Real + c1Ima * c2Ima) / (c2Real * c2Real + c2Ima * c2Ima);
                double imaginary = (c1Ima * c2Real - c1Real * c2Ima) / (c2Real * c2Real + c2Ima * c2Ima);
                return (new ComplexNumber(real, imaginary)).toString();
        }

        public String abs() {
                double real = this.getReal();
                double imaginary = this.getImaginary();
                double result = Math.sqrt(real * real + imaginary * imaginary);
                return String.valueOf(result);
        }

        @Override
        public String toString() {
                return this.a + " + " + this.b + "i";
        }

        @Override
        public int intValue() {
                return (int) this.getReal();
        }

        @Override
        public long longValue() {
                return (long) this.getReal();
        }

        @Override
        public float floatValue() {
                return (float) this.getReal();
        }

        @Override
        public double doubleValue() {
                return this.getReal();
        }

        @Override
        public int compareTo(Number o) {
                return this.intValue() - o.intValue();
        }

}
