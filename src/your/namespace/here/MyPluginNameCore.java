package your.namespace.here;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * TO USER:
 * If your copying this now, then some things you should check to ensure that everything is working:
 * prints message when enabled and when disabled
 * prints message when you type /hello world
 * prints message when you type /hello
 * prints message when you type /differentcommand
 * prints message when you type console only from the console
 */

public class MyPluginNameCore extends JavaPlugin { // JavaPlugin deals with
													// anything/everything
													// plugin related
	private final String version = "v0.1";
	private final String prefix = "[MyPlugin]"; /*
												 * these two variables are not
												 * required, but they simplify
												 * everything. Instead of
												 * changing 20 version
												 * statements every time you
												 * update your plugin, you only
												 * have to change this and
												 * plugin.ym
												 */

	Logger log = Logger.getLogger("Minecraft");// gets a logger object so we can
												// log things to the console

	public void onEnable() { // called when the plugin enables
		log.info(prefix + " " + version + " enabled!"); // logs to the console
														// that your plugin
														// enabled
	}

	public void onDisable() {// called when the plugin disables
		log.info(prefix + " disabled");
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) { /*
												 * this gets called when
												 * someone(player or console)
												 * types a command sender is the
												 * object for the person who
												 * sent it cmd is the command
												 * that was sent commandLabel
												 * isn't used much, its the
												 * label for the command args is
												 * any aditional information
												 * supplied by the player. e.x
												 * if the player typed /hello
												 * world then world would be
												 * args[0]
												 */
		if (sender instanceof Player) {// Checks if the sender is a player.
			if (cmd.getName().equalsIgnoreCase("hello")) {
				/*
				 * if the command equals "hello", regardless of case, we will do
				 * something
				 */
				if (args.length == 0) {/*
										 * this would mean the only thing the
										 * player typed is /hello, no arguments.
										 * if so, we are going to print
										 * "MyPlugin by tips48"
										 */
					sender.sendMessage("MyPlugin by tips48");/*
															 * sender.sendMessage
															 * is a method built
															 * into bukkit to
															 * display a message
															 * to the sender.
															 */
					if (sender.isOp()) {// checks if the player is op. another
										// function written into bukkit
						sender.sendMessage(ChatColor.GREEN + "Hello OP!");/*
																		 * This
																		 * time,
																		 * we
																		 * utilize
																		 * ChatColor
																		 * ...
																		 * ChatColor
																		 * is a
																		 * enum
																		 * built
																		 * into
																		 * bukkit
																		 * . It
																		 * makes
																		 * whatever
																		 * message
																		 * your
																		 * displaying
																		 * a
																		 * color
																		 */
						return true;/*
									 * this is not required, just highly
									 * recommended. it stops doing everything,
									 * because there is nothing left to do, and
									 * then returns a value of "true" for other
									 * plugins/bukkit to use(true means that we
									 * did something)
									 */
					} else if (args.length == 1) {// since we know that there
													// aren't
													// 0 args, now we check if
													// there
													// is one
						if (args[0].equalsIgnoreCase("world")) {// this checks
																// if
							/*
							 * the arg is world. this would mean the player
							 * typed /hello world
							 */
							sender.sendMessage(ChatColor.AQUA + "Hello World!");/*
																				 * sends
																				 * a
																				 * message
																				 * to
																				 * the
																				 * sender
																				 * "Hello world!"
																				 * Once
																				 * again
																				 * utilizes
																				 * ChatColor
																				 */
							return true; // same as above
						} else {/*
								 * the player typed something other than /hello
								 * world. we want the first arg to only be
								 * world, so we tell the sender to only type
								 * /hello world
								 */
							sender.sendMessage("Wrong args!  Try /hello world");// we
							/*
							 * tell the player to only type /hello world
							 */
							return true;// same as above
						}
					} else {// the sender entered more than one arg. we will
							// tell
							// them to only type one.
						sender.sendMessage("Wrong args!  Type /hello world or /hello");
						return true; // same as above
					}
				}
			} else {
				if (cmd.getName().equalsIgnoreCase("differentcommand")) {
					/*
					 * if you have more then one command, you would create a if
					 * statement and then check the command, like shown above
					 */
					sender.sendMessage("You executed another command.");
					return true;// same as above
				}
			}
		} else {/*
				 * the sender is typing from the console, so we will tell them
				 * "Hello console" if they typed console
				 */
			if (cmd.getName().equalsIgnoreCase("console")) {// if the console
															// typed console
				sender.sendMessage("Hello console");// sends the console a
													// message hello console
				return true;// same as above
			}

		}
		return false;// we return false because we didn't do anything
	}
}
