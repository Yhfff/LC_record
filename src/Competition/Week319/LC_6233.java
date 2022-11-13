package Competition.Week319;

//温度转换
public class LC_6233 {
    public static double[] convertTemperature(double celsius) {
        double res[] = new double[2];
        double Kelvin = celsius + 273.15; //开氏度
        double Fahrenheit = celsius * 1.80 + 32.00; //华氏度

        res[0] = Kelvin;
        res[1] = Fahrenheit;
        return res;

    }

    public static void main(String[] args) {
        double celsius = 122.11;
        double a = 8;

        System.out.println(a);
        double[] res = convertTemperature(celsius);
        for (double x: res) {
            System.out.println(x);
        }
        StringBuilder sb = new StringBuilder();

        sb.append('a');
        System.out.println(sb.toString());
    }
}
