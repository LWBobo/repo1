
public class Product {

		String name;
		String  id;
		double piece;
		Product(String str1 , String str2 , double a){
			this.name = str1;
			this.id = str2;
			this.piece = a;		
			
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public double getPiece() {
			return piece;
		}
		public void setPiece(double piece) {
			this.piece = piece;
		}
		public void displayInof() {
			System.out.println("商品信息:" + "\n" + "名字:" +this.getName() + "\n" +"编号："+ this.getId() + "\n" +"单价"+ this.piece + "\n");
		}
}
