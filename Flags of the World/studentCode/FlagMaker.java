package studentCode;
import java.awt.Color;
import GridTools.MyGrid;


public class FlagMaker {

	public static void drawFlag(MyGrid grid, int countryCode) {
		final int INDONESIA = 1;
		final int LITHUANIA = 2;
		final int RWANDA = 3;
		final int MALTA = 4;
		final int AFGHANISTAN = 5;
		final int ERITREA = 6;
		final int MACEDONIA = 7;
		final int THE_BAHAMAS = 8;
		final int ZIMBABWE = 9;
		
		int width = grid.getWd();
		int height = grid.getHt();
		
		errorFlag(grid);
			
		if (countryCode == INDONESIA) {
			if (height % 2 == 0) {
				for (int i = 0; i < height/2; i++) {
					drawRow(grid, i, Color.RED);
				}
				for (int j = (height - 1); j > height/2-1; j--) {
					drawRow(grid, j, Color.WHITE);
				}
			} else {
				errorFlag(grid);
			}

		} else if (countryCode == LITHUANIA) {
			if (height % 3 == 0) {
				int section = height/3;
				for (int i = 0; i < section; i++) {
					drawRow(grid, i, Color.YELLOW);
				}
				for (int j = section; j < section*2; j++) {
					drawRow(grid, j, Color.GREEN);
				}
				for (int x = section*2; x < section*3; x++) {
					drawRow(grid, x, Color.RED);
				} 
			} else {
				errorFlag(grid);
			}
			
		} else if (countryCode == RWANDA) {
			if (height % 4 ==0) {
				int section = height/2;
				for (int i = 0; i < section; i++) {
					drawRow(grid, i, Color.BLUE);
				}
				for (int j = section; j < section*(1.5); j++) {
					drawRow(grid, j, Color.YELLOW);
				}
				double temp = section*1.5;
				int lastSection = (int)temp;
				for (int x = lastSection; x < height; x++) {
					drawRow(grid, x, Color.GREEN);
				}
			} else {
				errorFlag(grid);
			}
				
		} else if (countryCode == MALTA) {
			for (int i = 0; i < width/2; i++) {
				drawCol(grid, i, Color.WHITE);
			}
			for (int j = (width/2); j < width; j++) {
				drawCol(grid, j, Color.RED);
			}
			
		} else if (countryCode == AFGHANISTAN) {
			if (height % 3 == 0) {
				int section = width/3;
				for (int i = 0; i < width/3; i++) {
					drawCol(grid, i, Color.BLACK);
				}
				for (int j = section; j < section*2; j++) {
					drawCol(grid, j, Color.RED);
				}
				for (int x = section*2; x < section*3; x++) {
					drawCol(grid, x, Color.GREEN);
				}
			} else {
				errorFlag(grid);
			}
			
		} else if (countryCode == ERITREA) {
			int section = height/2;
			int rowSection = 4; 
			for (int i = 0; i < section; i++) {
				drawRow(grid, i, Color.GREEN);
			}
			for (int j = section; j < height; j++) {
				drawRow(grid, j, Color.BLUE);
			}
			if (height % 2 == 0) {
				for (int row = 0; row < section; row++) {
					for (int col = 0; col < rowSection; col++) {
						grid.setColor(row, col, Color.RED);
					}
					rowSection+=4;
				}
				rowSection-=5;
				for (int newRow = section; newRow < height; newRow++) {
					for (int newCol = rowSection; newCol >= 0; newCol--) {
						grid.setColor(newRow, newCol, Color.RED);
					}
					rowSection-=4;
				}
			} else if (height % 2 == 1) {
				for (int row = 0; row < section; row++) {
					for (int col = 0; col < rowSection; col++) {
						grid.setColor(row, col, Color.RED);
					}
					rowSection+=4;
				}
				rowSection-=1;
				for (int newRow = section; newRow < height; newRow++) {
					for (int newCol = rowSection; newCol >= 0; newCol--) {
						if (newRow == section) {
							drawRow(grid, section, Color.RED);
						} else {
							grid.setColor(newRow, newCol, Color.RED);
						}			
					}
					rowSection-=4;
				}
			}
		} else if (countryCode == MACEDONIA) {
			if (height >= 8 && height % 2 == 0) {
				int rowDraw = height/2;
				int colDraw = width/2;
				for (int i = 0; i < height; i ++) {
					drawRow(grid, i, Color.RED);
				}
				drawRow(grid, rowDraw, Color.ORANGE);
				rowDraw--;
				drawRow(grid, rowDraw, Color.ORANGE);
				
				drawCol(grid, colDraw, Color.ORANGE);
				colDraw--;
				drawCol(grid, colDraw, Color.ORANGE);
				
				int rowSquare = rowDraw - 1;
				int colSquare = colDraw - 3;
				
				int endRow = rowSquare + 4;
				int endCol = colSquare + 8;
				for (int row = rowSquare; row < endRow; row++) {
					for (int col = colSquare; col < endCol; col++) {
						grid.setColor(row, col, Color.ORANGE);
					}
				}
				int colCounter = -1;
				for(int i = 0; i < height; i ++) {
					colCounter++;
					grid.setColor(i, colCounter, Color.ORANGE);
					colCounter++;
					grid.setColor(i, colCounter, Color.ORANGE);
				}
				colCounter = width;
				for(int i = 0; i < height; i ++) {
					colCounter--;
					grid.setColor(i, colCounter, Color.ORANGE);
					colCounter--;
					grid.setColor(i, colCounter, Color.ORANGE);
				}
				
			} else {
				errorFlag(grid);
			}
			
		} else if (countryCode == THE_BAHAMAS) {
			if (height % 3 == 0 && height % 2 == 1) {
				int section = height / 3;
				int section2 = section + (height/3);
				int triangleHeight = (height/2)+1;
				for (int row = 0; row < section; row++) {
					drawRow(grid, row, Color.BLUE);
				}
				for (int row = section; row < section2; row++) {
					drawRow(grid, row, Color.YELLOW);
				}
				for (int row = section2; row < height; row++) {
					drawRow(grid, row, Color.BLUE);
				}
				int row = 0;
				int col = 0;
	            while (row < triangleHeight) {
	            	col = 0;
	            	while (col <= row) {
	            		grid.setColor(row, col, Color.BLACK);
	                    col++;
	                  }
	               row++;
				}
	           
	            while (row < height) {
	                  int colCounter = 0;
	                  while ((colCounter+1) <= height - row) {
	                        grid.setColor(row, colCounter, Color.BLACK);
	                        colCounter++;
	                  }
	                  row++;
	            }            
	            
			} else {
				errorFlag(grid);
			}
		} else if (countryCode == ZIMBABWE) {
			if (height % 7 == 0) {
				int section = height / 7;
				
				for (int row = 0; row < section; row++) {
					drawRow(grid, row, Color.GREEN);
				}
				for (int row = section; row < section*2; row++) {
					drawRow(grid, row, Color.YELLOW);
				}
				for (int row = section*2; row < section*3; row++) {
					drawRow(grid, row, Color.RED);
				}
				for (int row = section*3; row < section*4; row++) {
					drawRow(grid, row, Color.BLACK);
				}
				for (int row = section*4; row < section*5; row++) {
					drawRow(grid, row, Color.RED);
				}
				for (int row = section*5; row < section*6; row++) {
					drawRow(grid, row, Color.YELLOW);
				}
				for (int row = section*6; row < height; row++) {
					drawRow(grid, row, Color.GREEN);
				}
				
				int triangleHeight = (height / 2) + 1;
				if (height % 2 == 1) {
					int row = 0;
					int col = 0;
		            while (row < triangleHeight) {
		            	col = 0;
		            	while (col <= row) {
		            		grid.setColor(row, col, Color.WHITE);
		                    col++;
		                  }
		               row++;
					}
		           
		            while (row < height) {
		                  int colCounter = 0;
		                  while ((colCounter+1) <= height - row) {
		                        grid.setColor(row, colCounter, Color.WHITE);
		                        colCounter++;
		                  }
		                  row++;
		            }            
				} else if (height % 2 == 0) {
					int row = 0;
					int col = 0;
		            while (row < triangleHeight-1) {
		            	col = 0;
		            	while (col <= row) {
		            		grid.setColor(row, col, Color.WHITE);
		                    col++;
		                  }
		               row++;
					}
		            
		            while (row < height) {
		            	int colCounter = 0;
		                while ((colCounter) <= height - row - 1) {
		                	grid.setColor(row, colCounter, Color.WHITE);
		                	colCounter++;
		                }
		                row++;
		            }             
				}
			} else {
				errorFlag(grid);
			}
		}
		
	}
	
	public static void drawRow(MyGrid grid, int row, Color color) {
		int width = grid.getWd();
		
		for (int col = 0; col < width; col++) {
			grid.setColor(row, col, color);
		}
	}
	
	public static void drawCol(MyGrid grid, int col, Color color) {
		int height = grid.getHt();
		
		for(int row = 0; row < height; row++) {
			grid.setColor(row, col, color);
		}
	}
	
	public static void errorFlag(MyGrid grid) {
		int height = grid.getHt();
		int width = grid.getWd();
		
		for (int row = 0; row < height; row++) {
			drawRow(grid, row, Color.WHITE);
		}
		grid.setColor(0, 0, Color.RED);
		grid.setColor(height-1, 0, Color.BLUE);
		grid.setColor(0, width-1, Color.YELLOW);
		grid.setColor(height-1, width-1, Color.GREEN);
	}
	
	                                                                         
}