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

	private GameEngine gameEngine;

	protected static void setGameEngine(GameEngine gameEngine) {
		gem.gameEngine = gameEngine;
	}

	protected static GameEngine getGameEngine() {
		return gem.gameEngine;
	}

	protected static void destroy() {
		if (gem != null) {
			if (gem.gameEngine != null) {
				gem.gameEngine = null;
			}
			gem = null;
		}
	}
}
