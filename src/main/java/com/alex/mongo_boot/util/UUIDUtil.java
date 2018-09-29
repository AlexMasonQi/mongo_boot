package com.alex.mongo_boot.util;

import java.util.UUID;

public class UUIDUtil
{
    public static String getRandomUUID()
    {
        UUID uuid = UUID.randomUUID();
        StringBuilder builder = new StringBuilder();
        String[] arr = uuid.toString().split("-");
        for (String s : arr)
        {
            builder.append(s);
        }

        return builder.toString();
    }
}
