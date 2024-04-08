public class FindingCountCharactersToFillConsole implements IConsoleLayoutManager  {
    @Override
    public int calculateCharsToFillLastLine(int consoleWidth, String text) {
        int _textLength = text.length();
        int _remainder = _textLength % consoleWidth;
        int _charsToFillLastLine = 0;

        if (_remainder > 0) {
            _charsToFillLastLine = consoleWidth - _remainder;
        }

        return _charsToFillLastLine;
    }
}
