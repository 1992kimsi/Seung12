import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class Program {

	public static void main(String[] args) throws RserveException, REXPMismatchException{
		RConnection con = null;
		
		con = new RConnection();
		
		StringBuilder r = new StringBuilder();
		r.append("data<-1:10;");
		r.append("s<-sum(data);");
		double sum = con.eval(r.toString()).asDouble();
	
		System.out.println(sum);
	}
}
