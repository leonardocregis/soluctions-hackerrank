package com.lcr.hackerrank.exercices.applesandorange;

class Tree implements Comparable<Tree>{
	int location;
	String name;
	public Tree(String name, int location) {
		super();
		this.location = location;
		this.name = name;
	}

	public int fallFruit(int fruitRelativeLocation){
		return location + fruitRelativeLocation;
	}

	public int compareTo(Tree o) {
		return o.name.compareTo(o.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + location;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tree other = (Tree) obj;
		if (location != other.location)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}