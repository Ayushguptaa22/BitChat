import java.util.Arrays;

//create a method to create blocks and make it accessible in client class
public class Block {
//		String[] l1= {"aa","bb"};
//		String[] l2= {"aa","bb"};
//		
//		System.out.println(Arrays.hashCode(l1));
//		System.out.println(Arrays.hashCode(l2));
		
		//HAsh= digital Signature
		//Each block has 
				//list of transactions
				//prev hash
				//hash
	private int previousHash;
	private String[] transactions;
	private int blockHash;
	
	public Block(int previousHash,String[] transactions) {
		this.previousHash=previousHash;
		this.transactions=transactions;
		
		Object[] contents= {Arrays.hashCode(transactions), previousHash};
		this.blockHash=Arrays.hashCode(contents);
		
		
	}

	public int getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(int previousHash) {
		this.previousHash = previousHash;
	}
 
	public String[] getTransactions() {
		return transactions;
	}

	public void setTransactions(String[] transactions) {
		this.transactions = transactions;
	}
	
	public int getBlockHash() {
		return blockHash;
	}
	public void setBlockHash(int blockHash) {
		this.blockHash=blockHash;
	}
}
