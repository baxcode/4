/*
 * * Copyright (C) 2014 Matt Baxter http://kitteh.org
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.kitteh.craftirc.command;

import org.kitteh.craftirc.CraftIRC;
import org.kitteh.craftirc.endpoint.Message;
import org.kitteh.craftirc.endpoint.TargetedMessage;
import org.kitteh.craftirc.endpoint.link.Link;
import org.kitteh.craftirc.exceptions.CraftIRCInvalidConfigException;
import org.kitteh.craftirc.util.MapGetter;
import org.kitteh.craftirc.util.loadable.Loadable;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

/**
 * Commands can be run anywhere!
 */
public abstract class Command extends Loadable {
    private String name;

    /**
     * Gets the name of this Command.
     *
     * @return the name of this command
     */
    @Nonnull
    public final String getName() {
        return this.name;
    }

    /**
     * Loads this command's data.
     *
     * @param data information to load
     * @throws CraftIRCInvalidConfigException
     */
    protected void load(@Nonnull Map<Object, Object> data) throws CraftIRCInvalidConfigException {

    }

    @Override
    protected final void load(@Nonnull CraftIRC plugin, @Nonnull Map<Object, Object> data) throws CraftIRCInvalidConfigException {
        this.name = MapGetter.getString(data, "name");
        this.load(data);
    }

    public abstract void execute(CommandContext context);
}