import java.io.*;


public class Main{


	public static void main(String [] args){
		IntReader in = new IntReader(System.in);
		StringBuffer output = new StringBuffer();
		int testCount = in.nextInt();
		outer: while (testCount-- > 0){
			int cars = in.nextInt();
			int wander = in.nextInt();
			int ready = in.nextInt();
			int p = in.nextInt();
			int r = in.nextInt();
			int k = in.nextInt();
			int done = 0;

			if (cars == 0){
				int movedToReady = Math.min(wander, k/r);
				output.append("0 0 " + (wander - movedToReady) + " " + (ready + movedToReady) + "\n");
				continue;
			}
			
			int[] carLeftAt = new int[cars];
			for (int i = 0; i < cars; i++)
				carLeftAt[i] = -p;
			int nextCar = 0;
	
			for (int time = 0; time < k; time++){
				// Passenger moved to wait for a ride
				if (((time+1) % r == 0) && (wander > 0)){
					ready++;
					wander--;
				}
				
				// Cars moving out to ride
				while ((ready > 0) && (time - carLeftAt[nextCar] >= p)){ // Passenger ready and car available
					if (carLeftAt[nextCar] >= 0)
						done++;
					carLeftAt[nextCar] = time;
					nextCar = (nextCar+1) % cars;
					ready--;
				}
				
				if ((wander == 0) && (ready == 0))
					break;
			}
			
			int carsWaiting = 0;
			for (int i = 0; i < cars; i++){
				if ((k-1) - carLeftAt[i] >= p){
					carsWaiting++;
					if (carLeftAt[i] >= 0)
						done++;
				}
			}
			
			output.append(Integer.toString(carsWaiting));
			output.append(' ');
			output.append(Integer.toString(done));
			output.append(' ');
			output.append(Integer.toString(wander));
			output.append(' ');
			output.append(Integer.toString(ready));
			output.append('\n');
		}
		System.out.print(output.toString());
	}

}


final class IntReader{

	private final InputStream in;
	private final byte[] buffer = new byte[1<<16];
	private int pos, count;
	
	public IntReader(InputStream in){
		this.in = in;
		pos = count = 0;
	}

	public int nextInt(){
		int c;
		while ((c = read()) < '0');
		
		int result = c - '0';
		while ((c = read() - '0') >= 0)
			result = 10*result + c;
		return result;
	}

	private void fillBuffer(){
		try{
			count = in.read(buffer, pos = 0, buffer.length);
		} catch (Exception e){}
	}

	private int read(){
		if (pos == count)
			fillBuffer();
		return buffer[pos++];
	}

}

