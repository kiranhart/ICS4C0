package com.thehartbusiness.unittest;

enum TileType {
	WHITE(0), BLACK(1), RED_PLAYER(2), WHITE_PLAYER(3);

	private int type;

	TileType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
