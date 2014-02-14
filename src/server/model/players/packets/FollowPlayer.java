package server.model.players.packets;

import server.core.PlayerHandler;
import server.model.players.Client;
import server.model.players.PacketType;

/**
 * Follow Player
 **/
public class FollowPlayer implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int followPlayer = c.getInStream().readUnsignedWordBigEndian();
		if (PlayerHandler.players[followPlayer] == null) {
			return;
		}
		c.playerIndex = 0;
		c.npcIndex = 0;
		c.mageFollow = false;
		c.usingBow = false;
		c.usingRangeWeapon = false;
		c.followDistance = 1;
		c.followId = followPlayer;
	}
}
