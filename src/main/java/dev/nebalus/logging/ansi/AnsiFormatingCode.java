package dev.nebalus.libary.logging.ansi;

import java.util.List;

public enum AnsiFormatingCode {
	// Documentation:
	// https://singularitykchen.github.io/blog/2020/08/06/Glean-ANSI-Escape-Codes/

	// Foreground
	COLOR_BLACK_FG("30", FormatingType.COLOR),
	COLOR_RED_FG("31", FormatingType.COLOR),
	COLOR_GREEN_FG("32", FormatingType.COLOR),
	COLOR_YELLOW_FG("33", FormatingType.COLOR),
	COLOR_BLUE_FG("34", FormatingType.COLOR),
	COLOR_MAGENTA_FG("35", FormatingType.COLOR),
	COLOR_CYAN_FG("36", FormatingType.COLOR),
	COLOR_WHITE_FG("37", FormatingType.COLOR),
	COLOR_GRAY_FG("90", FormatingType.COLOR),

	COLOR_RED_FG_BRIGHT("91", FormatingType.COLOR),
	COLOR_GREEN_FG_BRIGHT("92", FormatingType.COLOR),
	COLOR_YELLOW_FG_BRIGHT("93", FormatingType.COLOR),
	COLOR_BLUE_FG_BRIGHT("94", FormatingType.COLOR),
	COLOR_MAGENTA_FG_BRIGHT("95", FormatingType.COLOR),
	COLOR_CYAN_FG_BRIGHT("96", FormatingType.COLOR),
	COLOR_WHITE_FG_BRIGHT("97", FormatingType.COLOR),

	COLOR_BLACK_BG("40", FormatingType.BACKGROUNDCOLOR),
	COLOR_RED_BG("41", FormatingType.BACKGROUNDCOLOR),
	COLOR_GREEN_BG("42", FormatingType.BACKGROUNDCOLOR),
	COLOR_YELLOW_BG("43", FormatingType.BACKGROUNDCOLOR),
	COLOR_BLUE_BG("44", FormatingType.BACKGROUNDCOLOR),
	COLOR_MAGENTA_BG("45", FormatingType.BACKGROUNDCOLOR),
	COLOR_CYAN_BG("46", FormatingType.BACKGROUNDCOLOR),
	COLOR_WHITE_BG("47", FormatingType.BACKGROUNDCOLOR),
	COLOR_GRAY_BG("100", FormatingType.BACKGROUNDCOLOR),

	COLOR_RED_BG_BRIGHT("101", FormatingType.BACKGROUNDCOLOR),
	COLOR_GREEN_BG_BRIGHT("102", FormatingType.BACKGROUNDCOLOR),
	COLOR_YELLOW_BG_BRIGHT("103", FormatingType.BACKGROUNDCOLOR),
	COLOR_BLUE_BG_BRIGHT("104", FormatingType.BACKGROUNDCOLOR),
	COLOR_MAGENTA_BG_BRIGHT("105", FormatingType.BACKGROUNDCOLOR),
	COLOR_CYAN_BG_BRIGHT("106", FormatingType.BACKGROUNDCOLOR),
	COLOR_WHITE_BG_BRIGHT("107", FormatingType.BACKGROUNDCOLOR),

	STYLE_INTENSITY_BRIGHT("1", FormatingType.STYLE), //
	STYLE_INTENSITY_FAINT("2", FormatingType.STYLE), //
	STYLE_ITALIC("3", FormatingType.STYLE), // Not widely supported. Sometimes treated as inverse or blink.
	STYLE_UNDERLINED("4", FormatingType.STYLE), // Style extensions exist for Kitty, VTE, mintty and iTerm2.
	STYLE_SLOW_BLINK("5", FormatingType.STYLE), // less than 150 per minute
	STYLE_RAPID_BLINK("6", FormatingType.STYLE), // MS-DOS ANSI.SYS, 150+ per minute; not widely supported
	STYLE_REVERSE_VIDEO("7", FormatingType.STYLE), // swap foreground and background colors, aka invert; inconsistent emulation
	STYLE_HIDE("8", FormatingType.STYLE), // aka Conceal, not widely supported.
	STYLE_STRIKE("9", FormatingType.STYLE), // aka Crossed-out, characters legible but marked as if for deletion
	STYLE_FRAMED("51", FormatingType.STYLE), //

	RESET("0", FormatingType.RESETER); // All attributes off

	private final String code;
	private final FormatingType type;

	AnsiFormatingCode(String code, FormatingType type) {
		this.code = code;
		this.type = type;
	}

	public String getCode()
	{
		return code;
	}

	public String getAnsiCode()
	{
		return "\033[" + code + "m";
	}

	public static String getAnsiRegex()
	{
		return "\003\\[[0-9;]*m";
	}

	@SuppressWarnings("incomplete-switch")
	public static String buildAnsiCode(AnsiFormatingCode... codes)
	{
		if (codes.length == 0) {
			return "";
		}

		if (List.of(codes).contains(AnsiFormatingCode.RESET)) {
			return RESET.getAnsiCode();
		}

		StringBuilder sb = new StringBuilder("\033[");

		AnsiFormatingCode color = null;
		AnsiFormatingCode backgroundColor = null;
		AnsiFormatingCode style = null;

		for (AnsiFormatingCode logFormatCodes : codes) {
			switch (logFormatCodes.type) {
			case COLOR:
				if (color == null) {
					color = logFormatCodes;
				}
				break;

			case BACKGROUNDCOLOR:
				if (backgroundColor == null) {
					backgroundColor = logFormatCodes;
				}
				break;

			case STYLE:
				if (style == null) {
					style = logFormatCodes;
				}
				break;
			}
		}

		if (color != null) {
			sb.append(";");
			sb.append(color.code);
		}

		if (backgroundColor != null) {
			sb.append(";");
			sb.append(backgroundColor.code);
		}

		if (style != null) {
			sb.append(";");
			sb.append(style.code);
		}

		sb.append("m");

		return sb.toString();
	}
}
