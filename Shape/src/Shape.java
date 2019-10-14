
public class Shape {
	/**
	 * 计算圆面积
	 * @param num
	 * @return
	 */
	public static double calcCircleArea(double num) {
		return (Math.PI*Math.PI *num);
	}
	/**
	 * 计算长方形面积
	 * @param length
	 * @param width
	 * @return
	 */
	public static double calcRectangleArea(double length , double width) {
		return (length * width);
	}
	/**
	 * 计算三角形面积
	 * @param num1
	 * @param num2
	 * @param num3
	 * @return
	 */
	public static double calcTriangleArea(double num1,double num2 ,double num3) {
		double p = (num1 + num2 + num3)/2.0;
		return (Math.sqrt(p*(p-num1)*(p-num2)*(p-num3)));
	}
	/**
	 * 机选圆的周长
	 * @param num
	 * @return
	 */
		public static double calcCirclePerimeter(double num) {
			return (Math.PI * 2 * num);
		}
		/**
		 * 计算圆面积
		 * @param length
		 * @param width
		 * @return
		 */
		public static double calcRectanglePerimeter(double length , double width) {
			return (2 * (length + width));
		}
		public static double calcTrianglePerimeter(double num1,double num2 ,double num3) {
			return (num1+ num2+ num3);
		}
		
		
}