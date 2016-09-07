package com.libgdx.support;

/**
 * 
 * @Title: GameEngineManager.java 
 * @Description: 
 * <pre>
 *  GameEngine的管理类
 * </pre>
 * @author shimanqiang
 */
public class GameEngineManager {
	private static GameEngineManager gem = new GameEngineManager();

	private GameEngineManager() {
	}
	
	public static GameEngineManager getInstance(){
		if(gem == null){
			gem = new GameEngineManager();
		}
		return gem;
	}

	private GameEngine gameEngine;

	protected void setGameEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	protected GameEngine getGameEngine() {
		return gameEngine;
	}

	protected void destroy() {
		if (gem != null) {
			if (gameEngine != null) {
				gameEngine = null;
			}
			gem = null;
		}
	}
}
