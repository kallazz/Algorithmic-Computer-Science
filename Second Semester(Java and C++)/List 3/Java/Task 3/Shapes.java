public class Shapes {
    public enum OneArgument implements ShapesInterfaceOne {
        SQUARE {
            @Override
            public double getArea(double a) {
                return Math.pow(a, 2);
            }

            @Override
            public double getPerimeter(double a) {
                return 4 * a;
            }

            @Override
            public String getName() {
                return "Square";
            }
        }, 

        DISC {
            @Override
            public double getArea(double a) {
                return Math.PI * Math.pow(a, 2);
            }

            @Override
            public double getPerimeter(double a) {
                return 2 * Math.PI * a;
            }

            @Override
            public String getName() {
                return "Disc";
            }
        },

        PENTAGON {
            @Override
            public double getArea(double a) {
                return (Math.pow(a, 2) / 4) * Math.sqrt(25 + 10*Math.sqrt(5));
            }

            @Override
            public double getPerimeter(double a) {
                return 5 * a;
            }

            @Override
            public String getName() {
                return "Pentagon";
            }
        },

        HEXAGON {
            @Override
            public double getArea(double a) {
                return (3.0/2.0) * Math.pow(a, 2) * Math.sqrt(3);
            }

            @Override
            public double getPerimeter(double a) {
                return 6 * a;
            }

            @Override
            public String getName() {
                return "Hexagon";
            }
        }
    }

    public enum TwoArguments implements ShapesInterfaceTwo {
        RECTANGLE {
            @Override
            public double getArea(double a, double b) {
                return a * b;
            }

            @Override
            public double getPerimeter(double a, double b) {
                return a * 2 + b * 2;
            }

            @Override
            public String getName() {
                return "Rectangle";
            }
        },

        RHOMBUS {
            @Override
            public double getArea(double a, double b) { //bok, kąt
                return Math.pow(a, 2) * Math.sin(Math.toRadians(b));
            }

            @Override
            public double getPerimeter(double a, double b) {
                return 4 * a;
            }

            @Override
            public String getName() {
                return "Rhombus";
            }
        }
    }
}