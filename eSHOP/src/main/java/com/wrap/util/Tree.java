package com.wrap.util;
import java.io.File;

public class Tree
{
	public static void main(final String[] args) throws Exception
	{
		final String[] args1 = { "E:\\MYPROJECTS\\docs\\wrapit-tab-structure" };
		final File folder = new File(
				(args1.length >= 1 && args1[0].length() > 0) ? args1[0]
						: ".");

		if (!folder.isDirectory())
		{
			throw new IllegalArgumentException("Invalid directory: " + folder.getName());
		}

		final int level = 0;
		System.out.println(renderFolder(folder, level, new StringBuilder(), false));
	}

	private static StringBuilder renderFolder(final File folder, final int level, final StringBuilder sb, final boolean isLast)
	{
		indent(sb, level, isLast).append(folder.getName()).append("\n");

		final File[] objects = folder.listFiles();

		for (int i = 0; i < objects.length; i++)
		{
			final boolean last = ((i + 1) == objects.length);

			if (objects[i].isDirectory())
			{
				renderFolder(objects[i], level + 1, sb, last);
			}
			else
			{
				renderFile(objects[i], level + 1, sb, last);
			}
		}

		return sb;
	}

	private static StringBuilder renderFile(final File file, final int level, final StringBuilder sb, final boolean isLast)
	{
		return indent(sb, level, isLast).append("--- ").append(file.getName()).append("\n");
	}

	private static StringBuilder indent(final StringBuilder sb, final int level, final boolean isLast)
	{
		for (int i = 1; i < level; i++)
		{
			sb.append("|  ");
		}

		if (level > 0)
		{
			sb.append(isLast
					? "`-"
							: "|-");
		}

		return sb;
	}

}