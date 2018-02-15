package com.lcr.hackerrank.exercices;

public class KangarooTask {

	public static void main(String[] args) { 
		KangarooTask kangaroTask = new KangarooTask(0,3,4,2);
		System.out.println(kangaroTask.kangarooMeet());
	}
	
	private Kangaroo kangaroo1;
	private Kangaroo kangaroo2;
	
	public KangarooTask(int x1, int v1, int x2, int v2 ) {
		this(new Kangaroo(x1, x1, v1), new Kangaroo(x2, x2, v2));
	}
	
	public KangarooTask(Kangaroo kangaroo1, Kangaroo kangaroo2) {
		super();
		this.kangaroo1 = kangaroo1;
		this.kangaroo2 = kangaroo2;
	}

	
	public boolean kangarooMeet () {
		class Summary { 
			int diffDistance = 0;
			int lastDiffDistance = 0;
			int distWithOneJump = 0;
			
			public int getDiffDistance() {
				return diffDistance;
			}

			public void setDiffDistance(int diffDistance) {
				this.lastDiffDistance = this.diffDistance;
				this.diffDistance = diffDistance;
			}


			public void setDistWithOneJump(int distWithOneJump) {
				this.distWithOneJump = distWithOneJump;
			}

			public int getLastDiffDistance() {
				return lastDiffDistance;
			}

			public int getDistWithOneJump() {
				return distWithOneJump;
			}

			@Override
			public String toString() {
				return "Summary [diffDistance=" + diffDistance + ", distWithOneJump=" + distWithOneJump + "]";
			}
		};
		
		Summary summary = new Summary();
		
		Kangaroo first;
		Kangaroo secound;
		if (this.kangaroo1.atualPos < this.kangaroo2.atualPos) {
			first = this.kangaroo1;
			secound = this.kangaroo2;
		} else {
			first = this.kangaroo2;
			secound = this.kangaroo2;
		}

		summary.setDiffDistance(secound.atualPos - first.atualPos);
		summary.setDistWithOneJump(secound.jump() - first.jump());
		System.out.println(summary.toString());
		boolean distanceReduces =  summary.diffDistance  > summary.distWithOneJump;
		while (distanceReduces) {
			summary.setDiffDistance(secound.atualPos - first.atualPos);
			summary.setDistWithOneJump(secound.jump() - first.jump());
			System.out.println(summary.toString());
			if (summary.diffDistance == 0) {
				return true;
			}
			if ( summary.getLastDiffDistance() == summary.getDiffDistance()) {
				return false;
			}
			distanceReduces =  summary.getDiffDistance() > summary.getDistWithOneJump();
		}
		System.out.println(summary.toString());
		return false;
	}
	
	static class Kangaroo {
		int startPos;
		int atualPos;
		int jumpDist;

		public Kangaroo(int startPos, int atualPos, int jumpDist) {
			super();
			this.startPos = startPos;
			this.atualPos = atualPos;
			this.jumpDist = jumpDist;
		}

		public int jump(){
			this.atualPos = atualPos + jumpDist;
			return atualPos;
		}
	}
}
