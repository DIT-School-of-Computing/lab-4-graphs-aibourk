package ie.tudublin;

import processing.core.PApplet;



public class Arrays extends PApplet
{
	int mode = 0;

	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	// float[] rainfall = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};
	float[] rainfall = {50,100,150,200,250,300,350,400,450,500,450,400};

	public float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e - d;

		float howFar = a - b;
		return d + (howFar / r1) * r2;
	}

	void randomize()
	{
		// for (int i = 0; i < rainfall.length; i++) {
		// 	rainfall[i] = random(500);
		// }
	}

	public void settings()
	{
		size(500, 500);


		String[] m1 = months;
		print(m1[0]);
		for(int i = 0; i < months.length; i ++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		for (String s : m1) {
			println(s);
		}

		int minIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] < rainfall[minIndex])
			{
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] > rainfall[maxIndex])
			{
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + " with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was " + months[maxIndex] + " with " + rainfall[maxIndex] + "rain");
		
		
		float tot = 0;
		for(float f:rainfall)
		{
			tot += f;
		}

		float avg = tot / (float) rainfall.length;

		// a b-c d-e;
		println(map1(5, 0, 10, 0, 100));
		// 50

		println(map1(25, 20, 30, 200, 300));
		// 250

		println(map1(26, 25, 35, 0, 100));
		// 10 


	}

	public void setup() {
		colorMode(HSB);
		background(0);
		randomize();		
	}

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}
	
	public void draw()
	{	
		
		float w = width * 0.8f; //400 / total width/length of chart
		int start = 50; //start of the graph's x axis

		switch (mode) {
			case 0:
				background(0);
				textSize(15);
                text("Click different numbers for different graphs", 140, 250);
				break;
			case 1: //bar chart
				background(0);			
				fill(360, 0, 100);
				stroke(360, 0, 100);

				//the axis
				line(width * 0.1f, width * 0.1f, width * 0.1f, width - (width * 0.1f)); // 50,50,50,450
				line(width * 0.1f, width - (width * 0.1f), width - (width * 0.1f), width - (width * 0.1f)); //50,450,450,450
				
				//the ticks and labels
				for(int i = 50; i < width-(w * 0.1); i = i + (int)w/10)
				{
					line(width * 0.1f, i, (width * 0.1f) - 5, i);
					text(((i-50)/40) * 50, (width * 0.02f), width - i );
				}
				for	(int i = 0; i < months.length; i++)
				{
					text(months[i], 50+(i*35) , 470);
				}

				//the bars of the barchart
				for(int i = 0; i < months.length; i++)
				{
					float widthOfColumn = w / (float)months.length;
					fill(i*20, 100, 360);
					rect(start + (i * widthOfColumn), width-start, widthOfColumn, -((rainfall[i]/500) * 400));
				}

				break;
			case 2: //line graph
				int spacing = 40;
				
				background(0);			
				fill(360, 0, 100);
				stroke(360, 0, 100);
				
				//the axis
				line(width * 0.1f, width * 0.1f, width * 0.1f, width - (width * 0.1f)); // 50,50,50,450
				line(width * 0.1f, width - (width * 0.1f), width - (width * 0.1f), width - (width * 0.1f)); //50,450,450,450
				
				//the ticks and labels
				for(int i = 50; i < width-(w * 0.1); i = i + (int)w/10)
				{
					line(width * 0.1f, i, (width * 0.1f) - 5, i);
					text(((i-50)/40) * 50, (width * 0.02f), width - i );
				}
				for	(int i = 0; i < months.length; i++)
				{
					text(months[i], 50+(i*35) , 470);
				}

				
				break;
		}
	}
}
