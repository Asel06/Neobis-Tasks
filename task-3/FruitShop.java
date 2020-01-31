public class FruitShop {
	class products {
	    private int id;
	    private String NameOfFruit;
	    private int PriceOfProduct;

		public void setId(int id) {
	       this.id = id;
	    }
	    public int getId() {
	       return id;
	    }
	    public void setNameOfFruit(String NameOfFruit) {
	       this.nameoffruit = NameOfFruit;
	    }
	    public String getNameOfFruit() {
	       return NameOfFruit;
	    }
	    public void setPriceOfProduct(int PriceOfProduct) {
	       this.PriceOfProduct = PriceOfProduct;
	    }
	    public int getPriceOfProduct() {
	       return PriceOfProduct;
	    }
	} 

	class StoreHouse {
		private int Money;
		private int IdOfProduct;
		private int AmountOfProduct;

		public void setMoney(String Money) {
	       this.Money = Money;
	    }
	    public int getMoney() {
	        return Money;
	    }
	    public void setIdOfProduct(String IdOfProduct) {
	       this.IdOfProduct = IdOfProduct;
	    }
	    public int getIdOfProduct() {
	        return IdOfProduct;
	    }
	    public void setAmountOfProduct(String AmountOfProduct) {
	       this.AmountOfProduct = AmountOfProduct;
	    }
	    public int getAmountOfProduct() {
	        return AmountOfProduct;
	    }
	}

	class customers {
		private int id;
	    private String NameOfCustomer;

		public void setId(int id) {
	       this.id = id;
	    }
	    public int getId() {
	        return id;
	    }
	    public void setNameOfCustomer(String NameOfCustomer) {
	       this.NameOfCustomer = NameOfCustomer;
	    }
	    public String getNameOfCustomer() {
	        return NameOfCustomer;
	    }
	}

	class Workers {
		private int id;
	    private String NameOfWorker;
	    private String Position;
	    private int Salary;

	    public void setId(int id) {
	       this.id = id;
	    }
	    public int getId() {
	        return id;
	    }
	    public void setNameOfWorker(String NameOfWorker) {
	       this.NameOfWorker = NameOfWorker;
	    }
	    public String getNameOfWorker() {
	        return NameOfWorker;
	    }
	    public void setSalary(int Salary) {
	       this.Salary = Salary;
	    }
	    public int getSalary() {
	        return Salary;
	    }
	    public void setPosition(String Position) {
	       this.Position = Position;
	    }
	    public String getPosition() {
	        return Position;
	    }
	}

	class Providers {
		private int id;
		private String NameOfProvider;
		
		public void setId(int id) {
	       this.id = id;
	    }
	    public int getId() {
	        return id;
	    }
	    public void setNameOfProvider(String NameOfProvider) {
	       this.NameOfProvider = NameOfProvider;
	    }
	    public String getNameOfProvider() {
	        return NameOfProvider;
	    }
	}

	class Delivery {
		private int id;
		private int IdOfProvider;
		private int IdOfProduct;
		private int AmountOfProduct;
		private int CostOfProducts;

		public void setId(int id) {
	       this.id = id;
	    }
	    public int getId() {
	        return id;
	    }
	    public void setIdOfProvider(int IdOfProvider) {
	       this.IdOfProvider = IdOfProvider;
	    }
	    public int getIdOfProvider() {
	        return IdOfProvider;
	    }
	    public void setIdOfProduct(int IdOfProduct) {
	       this.IdOfProduct = IdOfProduct;
	    }
	    public int getIdOfProduct() {
	        return IdOfProduct;
	    }
	    public void setAmountOfProduct(int AmountOfProduct) {
	       this.AmountOfProduct = AmountOfProduct;
	    }
	    public int getAmountOfProduct() {
	        return AmountOfProduct;AmountOfProduct
	    }
	    public void setCostOfProducts(int CostOfProducts) {
	       this.CostOfProducts = CostOfProducts;
	    }
	    public int getCostOfProducts() {
	        return CostOfProducts;
	    }
	}

	class Sold {
		private int id;
		private int IdOfProduct;
		private int AmountOfProduct;
		private int CostOfProducts;

		public void setId(int id) {
	       this.id = id;
	    }
	    public int getId() {
	        return id;
	    }
	    public void setIdOfProduct(int IdOfProduct) {
	       this.IdOfProduct = IdOfProduct;
	    }
	    public int getIdOfProduct() {
	        return IdOfProduct;
	    }
	    public void setAmountOfProduct(int AmountOfProduct) {
	       this.AmountOfProduct = AmountOfProduct;
	    }
	    public int getAmountOfProduct() {
	        return AmountOfProduct;AmountOfProduct
	    }
	    public void setCostOfProducts(int CostOfProducts) {
	       this.CostOfProducts = CostOfProducts;
	    }
	    public int getCostOfProducts() {
	        return CostOfProducts;
	    }
	}
}	   