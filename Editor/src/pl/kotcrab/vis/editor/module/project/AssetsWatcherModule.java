/**
 * Copyright 2014-2015 Pawel Pastuszak
 * 
 * This file is part of VisEditor.
 * 
 * VisEditor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * VisEditor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with VisEditor.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.kotcrab.vis.editor.module.project;

import com.badlogic.gdx.files.FileHandle;

import pl.kotcrab.vis.editor.util.DirectoryWatcher;
import pl.kotcrab.vis.editor.util.DirectoryWatcher.WatchListener;

public class AssetsWatcherModule extends ProjectModule {
	private DirectoryWatcher watcher;

	@Override
	public void init () {
		FileAccessModule fileAccess = projectContainter.get(FileAccessModule.class);
		FileHandle assetsFolder = fileAccess.getAssetsFolder();

		watcher = new DirectoryWatcher(assetsFolder.file().toPath());
		watcher.start();
	}

	@Override
	public void dispose () {
		watcher.stop();
	}

	public void addListener (WatchListener listener) {
		watcher.addListener(listener);
	}

	public boolean removeListener (WatchListener listener) {
		return watcher.removeListener(listener);
	}
}