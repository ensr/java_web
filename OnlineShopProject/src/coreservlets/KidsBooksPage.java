package coreservlets;

public class KidsBooksPage extends CatalogPage{
	
	private static final long serialVersionUID = 1L;

	public void init(){
		String[] ids = { "lewis001", "alexander001", "rowling001" };
		setItems(ids);
		setTitle("All-Time Best Children's Fantasy Books");
	}

}
